import 'package:flutter/material.dart';
import 'package:proj_p2/models/heroi.dart';
import 'package:proj_p2/models/personagem.dart';
import 'package:proj_p2/screens/dados.dart';
import 'package:proj_p2/utilities/network_helper.dart';
import 'package:rflutter_alert/rflutter_alert.dart';

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
                    _mudarTela(ultimo);
                    bool flag = false;

                    // adiciona na lista se nao estiver nela
                    _lista.forEach((element) {
                      if (element.nome == ultimo.nome) {
                        flag = true;
                        return;
                      }
                    });
                    if (!flag) {
                      adicionar_novo_registro();
                    }
                  } else if (controladorEntrada.text.isNotEmpty) {
                    alerta("assets/disappointed_shoto.jpg",
                        "Personagem nao encontrado");
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
                          _mudarTela(item);
                        },
                        child: ListTile(
                            title: Text(apresentaAtributo(item.alias)),
                            subtitle: Text(apresentaAtributo(item.nome)),
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

  String apresentaAtributo(String atributo) {
    if (atributo == null) {
      return "Sem alias";
    } else {
      return atributo;
    }
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

  void _mudarTela(myHero heroi) {
    Navigator.push(context,
        MaterialPageRoute(builder: (context) => ApresentarHero(heroi)));
  }

  void _pesquisar() async {
    if (controladorEntrada.text.isEmpty) {
      encontrado = null;
      alerta("assets/aizawa_sleeps.jpg", "Barra de procura vazia");
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

  void alerta(String imagem, String frase) {
    Alert(
      context: context,
      title: "Erro",
      desc: frase,
      image: Image.asset(imagem),
      buttons: [
        DialogButton(
          child: Text(
            "OK",
            style: TextStyle(color: Colors.white, fontSize: 20),
          ),
          onPressed: () => Navigator.pop(context),
          width: 120,
        )
      ],
    ).show();
  }

  void adicionar_novo_registro() {
    setState(() {
      _lista.add(ultimo);
    });
  }
}
