class myHero {
  var _nome;
  var _quirk;
  var _urlImagem;
  var _gender;
  var _height;
  var _alias;

  myHero(this._nome, this._quirk, this._urlImagem, this._gender, this._height,
      this._alias);

  get gender => _gender;

  get height => _height;

  get alias => _alias;

  get imagem => _urlImagem;

  get nome => _nome;

  get quirk => _quirk;
  @override
  String toString() {
    return 'myHero(_nome: $_nome, _quirk: $_quirk, _urlImagem: $_urlImagem, _gender: $_gender, _height: $_height, _description: $_alias)';
  }

  @override
  bool operator ==(Object o) {
    if (identical(this, o)) return true;

    return o is myHero &&
        o._nome == _nome &&
        o._quirk == _quirk &&
        o._urlImagem == _urlImagem &&
        o._gender == _gender &&
        o._height == _height &&
        o._alias == _alias;
  }
}
