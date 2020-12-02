import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:proj_p2/models/heroi.dart';

class ApresentarHero extends StatelessWidget {
  final myHero _meuHeroi;
  ApresentarHero(this._meuHeroi);

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
            appBar: AppBar(
              title: Text(_apresentaAtributo(_meuHeroi.alias)),
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
                      padding: const EdgeInsets.all(32.0),
                      child: SizedBox(
                        child: Image.network(_meuHeroi.imagem),
                      ),
                    ),
                  ),
                  Text(
                    "Nome: " + _apresentaAtributo(_meuHeroi.nome),
                    style: GoogleFonts.marvel(fontSize: 30),
                  ),
                  Text(
                    "Quirk(s): " + _apresentaAtributo(_meuHeroi.quirk),
                    style: GoogleFonts.marvel(fontSize: 30),
                  ),
                  Text(
                    "Genero: " + _apresentaAtributo(_meuHeroi.gender),
                    style: GoogleFonts.marvel(fontSize: 30),
                  ),
                  Text(
                    "Altura: " + _apresentaAtributo(_meuHeroi.height),
                    style: GoogleFonts.marvel(fontSize: 30),
                  ),
                ],
              ),
            )));
  }

  String _apresentaAtributo(String atributo) {
    if (atributo == null) {
      return "Nao se conhece ou nao sabemos";
    } else if (atributo.toString() == "Male") {
      return "Masculino";
    } else if (atributo.toString() == "Female") {
      return "Feminino";
    } else {
      return atributo.toString();
    }
  }
}
