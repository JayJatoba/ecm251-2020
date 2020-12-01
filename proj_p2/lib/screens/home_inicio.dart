import 'package:flutter/material.dart';
import 'package:proj_p2/models/heroi.dart';
import 'package:proj_p2/models/personagem.dart';
import 'package:proj_p2/screens/dados.dart';
import 'package:proj_p2/utilities/network_helper.dart';

class MinhaPaginaInicial extends StatefulWidget {
  @override
  _MinhaPaginaInicialState createState() => _MinhaPaginaInicialState();
}

class _MinhaPaginaInicialState extends State<MinhaPaginaInicial> {
  var _dados = "";
  Result encontrado;

  final controladorEntrada = TextEditingController();
  final controladorQuirk = TextEditingController();

  final controladorUrlImagem = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(
          title: Text("Minhas requisicoes"),
        ),
        body: Column(
          children: [
            SizedBox(
              child: Image.asset("assets/Boku_no_Hero_Academia_Logo.png"),
            ),
            meuTextFieldPersonalizado(
                controladorEntrada,
                "Izuku ou Deku...",
                "Nome ou Alias do personagem: ",
                Icon(Icons.drive_file_rename_outline)),
            FlatButton(
                onPressed: () {
                  Future<Result> resultado = pesquisar();
                  if (resultado != null) {
                    print(resultado);
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => ApresentarHero(
                                  myHero(
                                      resultado.name,
                                      encontrado.quirk,
                                      encontrado.images[0],
                                      encontrado.gender,
                                      encontrado.height,
                                      encontrado.description),
                                )));
                  } else {
                    print("Nao ha resutlado");
                  }
                },
                child: Text("Pesquisar")),
          ],
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.send),
          onPressed: () {
            if (controladorEntrada.text.isNotEmpty) {
              pesquisar();
              print(encontrado.name);
            } else {
              print("N sei");
            }
          },
        ),
      ),
    );
  }

  Widget meuTextFieldPersonalizado(
      TextEditingController controller, String hint, String label, Icon icone) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: TextField(
        controller: controller,
        decoration:
            InputDecoration(hintText: hint, labelText: label, icon: icone),
      ),
    );
  }

  Future<Result> pesquisar() async {
    if (controladorEntrada.text.isEmpty) {
      return null;
    }
    var requisicao = NetworkHelper(
        "https://myheroacademiaapi.com/api/character?alias=" +
            controladorEntrada.text);
    var dados = Personagem.fromJson(await requisicao.getData());
    if (dados.result.length != 0) {
      return dados.result[0];
    }
    requisicao = NetworkHelper(
        "https://myheroacademiaapi.com/api/character?name=" +
            controladorEntrada.text);
    dados = Personagem.fromJson(await requisicao.getData());
    if (dados.result.length != 0) {
      return dados.result[0];
    }
    return null;
  }

  // void adicionar_novo_registro() {
  //   setState(() {
  //     _myHerosList.add(myHero(controladorEntrada.text, controladorQuirk.text,
  //         controladorUrlImagem.text));
  //     print(_myHerosList);
  //   });
  // }
}
