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
  Result encontrado;
  final List<myHero> _lista = [];
  myHero ultimo;

  final controladorEntrada = TextEditingController();

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
                    _novoHeroi();
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => ApresentarHero(
                                  ultimo,
                                )));
                    bool flag = false;
                    _lista.forEach((element) {
                      if (element.nome == ultimo.nome) {
                        flag = true;
                        return;
                      }
                    });
                    if (!flag) {
                      adicionar_novo_registro();
                    }
                  } else {
                    print("Nao ha resultado");
                  }
                },
                child: Text("Pesquisar")),
            Expanded(
              child: ListView.builder(
                itemBuilder: (context, index) {
                  final item = _lista[index];
                  return Dismissible(
                      key: Key(item.nome),
                      onDismissed: (direction) {
                        setState(() {
                          _lista.removeAt(index);
                        });
                        Scaffold.of(context).showSnackBar(SnackBar(
                            content: Text("${item.nome} foi retirado(a)")));
                      },
                      background: Container(color: Colors.red),
                      child: InkWell(
                        onTap: () {
                          Navigator.push(
                              context,
                              MaterialPageRoute(
                                  builder: (context) => ApresentarHero(
                                        item,
                                      )));
                        },
                        child: ListTile(
                            title: Text(item.nome),
                            subtitle: Text(item.quirk),
                            leading: Image.network(item.imagem)),
                      ));
                },
                itemCount: _lista.length,
              ),
            )
          ],
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

  void _novoHeroi() {
    ultimo = myHero(encontrado.name, encontrado.quirk, encontrado.images[0],
        encontrado.gender, encontrado.height, encontrado.alias);
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
      _lista.add(ultimo);
    });
  }
}
