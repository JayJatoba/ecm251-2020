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
  final List<myHero> _lista = [];

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
                onPressed: () async {
                  encontrado = null;
// Este await fez dar certo a impementacao de _pesquisar()
                  await _pesquisar();

                  if (encontrado != null) {
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => ApresentarHero(
                                  myHero(
                                      encontrado.name,
                                      encontrado.quirk,
                                      encontrado.images[0],
                                      encontrado.gender,
                                      encontrado.height,
                                      encontrado.description),
                                )));
                    adicionar_novo_registro();
                  } else {
                    print("Nao ha resultado");
                  }
                },
                child: Text("Pesquisar")),
            Expanded(
              child: ListView.builder(
                itemBuilder: (context, index) {
                  return ListTile(
                      title: Text(_lista[index].nome),
                      subtitle: Text(_lista[index].quirk),
                      leading: Image.network(_lista[index].imagem));
                },
                itemCount: _lista.length,
              ),
            )
          ],
        ),
        // floatingActionButton: FloatingActionButton(
        //   child: Icon(Icons.send),
        //   onPressed: () {
        //     if (controladorEntrada.text.isNotEmpty) {
        //       _pesquisar();
        //       print(encontrado.name);
        //     } else {
        //       print("N sei");
        //     }
        //   },
        // ),
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

  void _pesquisar() async {
    if (controladorEntrada.text.isEmpty) {
      encontrado = null;
      return;
    }
    var requisicao = NetworkHelper(
        "https://myheroacademiaapi.com/api/character?alias=" +
            controladorEntrada.text);
    var dados = Personagem.fromJson(await requisicao.getData());
    if (dados.result.length != 0) {
      print("gwg");
      encontrado = dados.result[0];
      return;
    }
    requisicao = NetworkHelper(
        "https://myheroacademiaapi.com/api/character?name=" +
            controladorEntrada.text);
    dados = Personagem.fromJson(await requisicao.getData());
    if (dados.result.length != 0) {
      encontrado = dados.result[0];
      return;
    }
  }

  void adicionar_novo_registro() {
    setState(() {
      _lista.add(myHero(encontrado.name, encontrado.quirk, encontrado.images[0],
          encontrado.gender, encontrado.height, encontrado.description));
      print(_lista);
    });
  }
}
