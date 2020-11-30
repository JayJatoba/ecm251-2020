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
  final _myHerosList = [
    myHero("All Might", "One for All",
        "https://static.wikia.nocookie.net/bokunoheroacademia/images/c/cd/Toshinori_Yagi_Golden_Age_Hero_Costume_%28Anime%29.png/revision/latest?cb=20190129015644"),
    myHero("Midoriya", "One for All",
        "https://comicvine1.cbsistatic.com/uploads/square_small/11117/111173561/5994041-8086170340-63780.jpg"),
    myHero("Bakugou", "Explosao",
        "https://img.favpng.com/0/5/11/my-hero-academia-eijirou-kirishima-tenya-iida-character-boku-no-hero-academia-smash-png-favpng-3cwat4m5L3Ggp2ntKy51q3BJN.jpg"),
    myHero("Ochako", "Zero Gravity",
        "https://ovicio.com.br/wp-content/uploads/2019/10/20191028-uraraka-anime.jpg")
  ];

  final controladorEntrada = TextEditingController();
  final controladorQuirk = TextEditingController();
  String siteUrl;
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
                  // adicionar_novo_registro();
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => ApresentarHero(
                            myHero("Estranho", "Muito", "Muito"))),
                  );
                },
                child: Text("Pesquisar")),
            Expanded(child: ListView.builder(itemBuilder: (context, index) {
              return ListTile(
                  title: Text(_myHerosList[index].nome),
                  subtitle: Text(_myHerosList[index].quirk),
                  leading: Image.network(_myHerosList[index].imagem));
            }))
          ],
        ),
        floatingActionButton: FloatingActionButton(
          child: Icon(Icons.send),
          onPressed: () async {
            var requisicao = NetworkHelper(
                url: "https://myheroacademiaapi.com/api/character?alias=deku");
            var dados = Personagem.fromJson(await requisicao.getData());
            // if (dados.result[0] == null) {
            //   var requisicao = NetworkHelper(
            //       url: "https://myheroacademiaapi.com/api/character?name=" +
            //           controladorEntrada.toString());
            //   var dados = Personagem.fromJson(await requisicao.getData());
            // }
            print(dados.result[0].alias);
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

  void adicionar_novo_registro() {
    setState(() {
      _myHerosList.add(myHero(controladorEntrada.text, controladorQuirk.text,
          controladorUrlImagem.text));
      print(_myHerosList);
    });
  }
}
