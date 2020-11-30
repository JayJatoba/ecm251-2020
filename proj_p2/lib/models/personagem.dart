class Personagem {
  Info _info;
  List<Result> _result;

  Personagem({Info info, List<Result> result}) {
    this._info = info;
    this._result = result;
  }

  Info get info => _info;
  set info(Info info) => _info = info;
  List<Result> get result => _result;
  set result(List<Result> result) => _result = result;

  Personagem.fromJson(Map<String, dynamic> json) {
    _info = json['info'] != null ? new Info.fromJson(json['info']) : null;
    if (json['result'] != null) {
      _result = new List<Result>();
      json['result'].forEach((v) {
        _result.add(new Result.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this._info != null) {
      data['info'] = this._info.toJson();
    }
    if (this._result != null) {
      data['result'] = this._result.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class Info {
  int _currentPage;
  int _count;
  int _pages;

  Info({int currentPage, int count, int pages}) {
    this._currentPage = currentPage;
    this._count = count;
    this._pages = pages;
  }

  int get currentPage => _currentPage;
  set currentPage(int currentPage) => _currentPage = currentPage;
  int get count => _count;
  set count(int count) => _count = count;
  int get pages => _pages;
  set pages(int pages) => _pages = pages;

  Info.fromJson(Map<String, dynamic> json) {
    _currentPage = json['currentPage'];
    _count = json['count'];
    _pages = json['pages'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['currentPage'] = this._currentPage;
    data['count'] = this._count;
    data['pages'] = this._pages;
    return data;
  }
}

class Result {
  String _id;
  String _name;
  String _alias;
  String _affiliation;
  String _birthday;
  Null _bloodtype;
  String _description;
  Null _fightstyle;
  String _gender;
  String _eye;
  String _hair;
  String _height;
  String _kanji;
  String _occupation;
  String _quirk;
  String _romaji;
  String _status;
  String _teams;
  List<String> _images;
  Null _epithet;
  Null _ages;
  Null _family;

  Result(
      {String id,
      String name,
      String alias,
      String affiliation,
      String birthday,
      Null bloodtype,
      String description,
      Null fightstyle,
      String gender,
      String eye,
      String hair,
      String height,
      String kanji,
      String occupation,
      String quirk,
      String romaji,
      String status,
      String teams,
      List<String> images,
      Null epithet,
      Null ages,
      Null family}) {
    this._id = id;
    this._name = name;
    this._alias = alias;
    this._affiliation = affiliation;
    this._birthday = birthday;
    this._bloodtype = bloodtype;
    this._description = description;
    this._fightstyle = fightstyle;
    this._gender = gender;
    this._eye = eye;
    this._hair = hair;
    this._height = height;
    this._kanji = kanji;
    this._occupation = occupation;
    this._quirk = quirk;
    this._romaji = romaji;
    this._status = status;
    this._teams = teams;
    this._images = images;
    this._epithet = epithet;
    this._ages = ages;
    this._family = family;
  }

  String get id => _id;
  set id(String id) => _id = id;
  String get name => _name;
  set name(String name) => _name = name;
  String get alias => _alias;
  set alias(String alias) => _alias = alias;
  String get affiliation => _affiliation;
  set affiliation(String affiliation) => _affiliation = affiliation;
  String get birthday => _birthday;
  set birthday(String birthday) => _birthday = birthday;
  Null get bloodtype => _bloodtype;
  set bloodtype(Null bloodtype) => _bloodtype = bloodtype;
  String get description => _description;
  set description(String description) => _description = description;
  Null get fightstyle => _fightstyle;
  set fightstyle(Null fightstyle) => _fightstyle = fightstyle;
  String get gender => _gender;
  set gender(String gender) => _gender = gender;
  String get eye => _eye;
  set eye(String eye) => _eye = eye;
  String get hair => _hair;
  set hair(String hair) => _hair = hair;
  String get height => _height;
  set height(String height) => _height = height;
  String get kanji => _kanji;
  set kanji(String kanji) => _kanji = kanji;
  String get occupation => _occupation;
  set occupation(String occupation) => _occupation = occupation;
  String get quirk => _quirk;
  set quirk(String quirk) => _quirk = quirk;
  String get romaji => _romaji;
  set romaji(String romaji) => _romaji = romaji;
  String get status => _status;
  set status(String status) => _status = status;
  String get teams => _teams;
  set teams(String teams) => _teams = teams;
  List<String> get images => _images;
  set images(List<String> images) => _images = images;
  Null get epithet => _epithet;
  set epithet(Null epithet) => _epithet = epithet;
  Null get ages => _ages;
  set ages(Null ages) => _ages = ages;
  Null get family => _family;
  set family(Null family) => _family = family;

  Result.fromJson(Map<String, dynamic> json) {
    _id = json['id'];
    _name = json['name'];
    _alias = json['alias'];
    _affiliation = json['affiliation'];
    _birthday = json['birthday'];
    _bloodtype = json['bloodtype'];
    _description = json['description'];
    _fightstyle = json['fightstyle'];
    _gender = json['gender'];
    _eye = json['Eye'];
    _hair = json['hair'];
    _height = json['height'];
    _kanji = json['kanji'];
    _occupation = json['occupation'];
    _quirk = json['quirk'];
    _romaji = json['romaji'];
    _status = json['status'];
    _teams = json['teams'];
    _images = json['images'].cast<String>();
    _epithet = json['epithet'];
    _ages = json['ages'];
    _family = json['family'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this._id;
    data['name'] = this._name;
    data['alias'] = this._alias;
    data['affiliation'] = this._affiliation;
    data['birthday'] = this._birthday;
    data['bloodtype'] = this._bloodtype;
    data['description'] = this._description;
    data['fightstyle'] = this._fightstyle;
    data['gender'] = this._gender;
    data['Eye'] = this._eye;
    data['hair'] = this._hair;
    data['height'] = this._height;
    data['kanji'] = this._kanji;
    data['occupation'] = this._occupation;
    data['quirk'] = this._quirk;
    data['romaji'] = this._romaji;
    data['status'] = this._status;
    data['teams'] = this._teams;
    data['images'] = this._images;
    data['epithet'] = this._epithet;
    data['ages'] = this._ages;
    data['family'] = this._family;
    return data;
  }
}
