package razorclaw.object;

public class KeyPhraseScore {

	private String _phrase;

	private double _titleScore, _metaKeywordsScore, _metaDescriptionScore, _h1Score, _h2Score, _contentScore,
			_anchorTextScore, _spiderKeywordsScore, _adminKeywordsScore, _userKeywordsScore, _lengthScore,
			_searchQueryScore, _POSScore, _pseudoScore, _idfScore, _BM25FScore, _UCBScore;

	public KeyPhraseScore() {

	}

	public KeyPhraseScore(String scoreLine) {
		String[] arr = scoreLine.split("\t");

		setPhrase(arr[0]);
		setPseudoScore(Double.parseDouble(arr[1]));

		setTitleScore(Double.parseDouble(arr[2]));
		setMetaKeywordsScore(Double.parseDouble(arr[3]));
		setMetaDescriptionScore(Double.parseDouble(arr[4]));
		setH1Score(Double.parseDouble(arr[5]));
		setH2Score(Double.parseDouble(arr[6]));
		setContentScore(Double.parseDouble(arr[7]));
		setAnchorTextScore(Double.parseDouble(arr[8]));
		setPOSScore(Double.parseDouble(arr[9]));
	}

	public double[] getFeatureMatrix() {
		double[] ret = new double[8];

		ret[0] = getTitleScore();
		ret[1] = getMetaKeywordsScore();
		ret[2] = getMetaDescriptionScore();
		ret[3] = getH1Score();
		ret[4] = getH2Score();
		ret[5] = getContentScore();
		ret[6] = getAnchorTextScore();
		ret[7] = getPOSScore();

		return ret;
	}

	public String getFeatureString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getTitleScore());
		sb.append("\t");
		sb.append(getMetaKeywordsScore());
		sb.append("\t");
		sb.append(getMetaDescriptionScore());
		sb.append("\t");
		sb.append(getH1Score());
		sb.append("\t");
		sb.append(getH2Score());
		sb.append("\t");
		sb.append(getContentScore());
		sb.append("\t");
		sb.append(getAnchorTextScore());
		sb.append("\t");
		sb.append(getPOSScore());

		return sb.toString();
	}

	public String toString() {
		return getPhrase();
	}

	public void setTitleScore(double _titleScore) {
		this._titleScore = _titleScore;
	}

	public double getTitleScore() {
		return _titleScore;
	}

	public void setPOSScore(double _POSScore) {
		this._POSScore = _POSScore;
	}

	public double getPOSScore() {
		return _POSScore;
	}

	public void setSearchQueryScore(double _searchQueryScore) {
		this._searchQueryScore = _searchQueryScore;
	}

	public double getSearchQueryScore() {
		return _searchQueryScore;
	}

	public void setLengthScore(double _lengthScore) {
		this._lengthScore = _lengthScore;
	}

	public double getLengthScore() {
		return _lengthScore;
	}

	public void setSpiderKeywordsScore(double _spiderKeywordsScore) {
		this._spiderKeywordsScore = _spiderKeywordsScore;
	}

	public double getSpiderKeywordsScore() {
		return _spiderKeywordsScore;
	}

	public void setAdminKeywordsScore(double _adminKeywordsScore) {
		this._adminKeywordsScore = _adminKeywordsScore;
	}

	public double getAdminKeywordsScore() {
		return _adminKeywordsScore;
	}

	public void setUserKeywordsScore(double _userKeywordsScore) {
		this._userKeywordsScore = _userKeywordsScore;
	}

	public double getUserKeywordsScore() {
		return _userKeywordsScore;
	}

	public void setAnchorTextScore(double _anchorTextScore) {
		this._anchorTextScore = _anchorTextScore;
	}

	public double getAnchorTextScore() {
		return _anchorTextScore;
	}

	public void setContentScore(double _contentScore) {
		this._contentScore = _contentScore;
	}

	public double getContentScore() {
		return _contentScore;
	}

	public void setH2Score(double _h2Score) {
		this._h2Score = _h2Score;
	}

	public double getH2Score() {
		return _h2Score;
	}

	public void setH1Score(double _h1Score) {
		this._h1Score = _h1Score;
	}

	public double getH1Score() {
		return _h1Score;
	}

	public void setMetaKeywordsScore(double _metaKeywordsScore) {
		this._metaKeywordsScore = _metaKeywordsScore;
	}

	public double getMetaKeywordsScore() {
		return _metaKeywordsScore;
	}

	public void setMetaDescriptionScore(double _metaDescriptionScore) {
		this._metaDescriptionScore = _metaDescriptionScore;
	}

	public double getMetaDescriptionScore() {
		return _metaDescriptionScore;
	}

	public void setPhrase(String _phrase) {
		this._phrase = _phrase;
	}

	public String getPhrase() {
		return _phrase;
	}

	public void setIDFScore(double _idfScore) {
		this._idfScore = _idfScore;
	}

	public double getIDFScore() {
		return _idfScore;
	}

	public void setPseudoScore(double _pseudoScore) {
		this._pseudoScore = _pseudoScore;
	}

	public double getPseudoScore() {
		return _pseudoScore;
	}

	public void setBM25FScore(double _BM25FScore) {
		this._BM25FScore = _BM25FScore;
	}

	public double getBM25FScore() {
		return _BM25FScore;
	}

	public void setUCBScore(double _UCBScore) {
		this._UCBScore = _UCBScore;
	}

	public double getUCBScore() {
		return _UCBScore;
	}

	/**
	 * parse a line of string into feature values.
	 * 
	 * @param line
	 *            <title, meta_keyword, meta_description, h1, h2, content,
	 *            anchor_text, pos>
	 */
	public void parseFeatures(String line) {
		String[] arr = line.split("\t");

		setTitleScore(Double.parseDouble(arr[0]));
		setMetaKeywordsScore(Double.parseDouble(arr[1]));
		setMetaDescriptionScore(Double.parseDouble(arr[2]));
		setH1Score(Double.parseDouble(arr[3]));
		setH2Score(Double.parseDouble(arr[4]));
		setContentScore(Double.parseDouble(arr[5]));
		setAnchorTextScore(Double.parseDouble(arr[6]));
		setPOSScore(Double.parseDouble(arr[7]));

	}

	public void combineFeatures(KeyPhraseScore obj) {
		setTitleScore(getTitleScore() + obj.getTitleScore());
		setMetaKeywordsScore(getMetaKeywordsScore() + obj.getMetaKeywordsScore());
		setMetaDescriptionScore(getMetaDescriptionScore() + obj.getMetaDescriptionScore());
		setH1Score(getH1Score() + obj.getH1Score());
		setH2Score(getH2Score() + obj.getH2Score());
		setContentScore(getContentScore() + obj.getContentScore());
		setAnchorTextScore(getAnchorTextScore() + obj.getAnchorTextScore());
		setPOSScore(getPseudoScore() + obj.getPOSScore());
	}
}
