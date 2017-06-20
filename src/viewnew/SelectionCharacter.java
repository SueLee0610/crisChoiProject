package viewnew;

public class SelectionCharacter {

	private String titleImage;
	private String startImage;
	private String gameImage;
	private String characterClass;
	
	public SelectionCharacter(String titleImage, String startImage, String gameImage, String characterClass) {
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.characterClass = characterClass;
	}
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getCharacterClass() {
		return characterClass;
	}
	

}
