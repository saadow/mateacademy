package ProjectProxy;

public class ProjectProxy implements Project {
	private RealProject real;
	private String name;

	public ProjectProxy(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if (real.equals(null)) {
			real = new RealProject(name);
		}
		real.run();
	}

}
