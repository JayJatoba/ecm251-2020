import 'package:flutter/material.dart';
import 'package:proj_p2/models/heroi.dart';

class ApresentarHero extends StatelessWidget {
  final myHero _meuHeroi;
  ApresentarHero(this._meuHeroi);

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
            appBar: AppBar(
              title: Text(_meuHeroi.nome.toString()),
              centerTitle: true,
            ),
            body: Center(
              child: Column(
                children: [
                  SizedBox(
                    width: 300,
                    height: 150,
                    child: Image.asset("assets/Boku_no_Hero_Academia_Logo.png"),
                  ),
                  Expanded(
                    child: Padding(
                      padding: const EdgeInsets.all(64.0),
                      child: SizedBox(
                        child: Image.network(_meuHeroi.imagem),
                      ),
                    ),
                  ),
                  Text(_meuHeroi.alias.toString()),
                  Text(_meuHeroi.quirk.toString()),
                  Text(_meuHeroi.gender.toString()),
                  Text(_meuHeroi.height.toString()),
                ],
              ),
            )));
  }
}
