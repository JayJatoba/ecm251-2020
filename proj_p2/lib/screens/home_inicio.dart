import 'package:flutter/material.dart';
import 'package:proj_p2/models/personagem.dart';
import 'package:proj_p2/utilities/network_helper.dart';

class MinhaPaginaInicial extends StatelessWidget {
  var _dados = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Minhas requisicoes"),
      ),
      body: Text(_dados),
      floatingActionButton: FloatingActionButton(
        child: Icon(Icons.send),
        onPressed: () async {
          var requisicao = NetworkHelper(
              url: "https://myheroacademiaapi.com/api/character?alias=twice");
          var dados = Personagem.fromJson(await requisicao.getData());
          print(dados.result[0].name);
        },
      ),
    );
  }
}
