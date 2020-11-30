import 'package:flutter/material.dart';
import 'package:proj_p2/models/heroi.dart';
import 'package:proj_p2/screens/home_inicio.dart';

class ApresentarHero extends StatelessWidget {
  var _meuHeroi;
  ApresentarHero(this._meuHeroi);

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
            appBar: AppBar(
              title: Text("Detalhes de: " + _meuHeroi.nome),
            ),
            body: Center(
              child: Column(
                children: [
                  SizedBox(
                    width: 300,
                    height: 150,
                    child: Image.asset("assets/Boku_no_Hero_Academia_Logo.png"),
                  ),
                ],
              ),
            )));
  }
}
