package ProjectProxy;

public class RealProject implements Project {

	String name;

	public RealProject(String name) {
		this.name = name;
		pullFromGithub(name);
	}

	@Override
	public void run() {
		System.out.println("Running project " + name);
	}

	public void pullFromGithub(String name) {
		System.out.println("Pulling " + name + " from Github");
	}

}
