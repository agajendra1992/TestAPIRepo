package App.Generic;

public enum Endpoint {

	CREATEUSERS("users"), GETSINGLEUSER("users/"), GETDELETEUSER("users/");
	String resourcePath;

	Endpoint(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String getresourcePath() {
		return this.resourcePath;
	}

	public String getresourcePath(String data) {
		return this.resourcePath;
	}

}
