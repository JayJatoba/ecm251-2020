class myHero {
  var _nome;
  var _quirk;
  var _urlImagem;
  var _gender;
  var _height;
  var _description;

  myHero(this._nome, this._quirk, this._urlImagem, this._gender, this._height,
      this._description);

  get gender => _gender;

  get height => _height;

  get description => _description;

  get imagem => _urlImagem;

  get nome => _nome;

  get quirk => _quirk;

  @override
  String toString() {
    return 'myHero{_nome: $_nome, _quirk: $_quirk, _urlImagem: $_urlImagem}';
  }
}
