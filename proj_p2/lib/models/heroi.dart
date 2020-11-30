class myHero {
  var _nome;
  var _quirk;
  var _urlImagem;

  myHero(this._nome, this._quirk, this._urlImagem);

  @override
  String toString() {
    return 'myHero{_nome: $_nome, _quirk: $_quirk, _urlImagem: $_urlImagem}';
  }

  get quirk => _quirk;

  get nome => _nome;
  get imagem => _urlImagem;
}
