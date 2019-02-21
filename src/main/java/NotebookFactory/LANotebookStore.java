package NotebookFactory;

public class LANotebookStore extends NotebookStore {

	@Override
	Notebook createNotebook(String type) {
		Notebook notebook = null;
		if ("gaming".equals(type)) {
			notebook = new LAAsusROG();
		} else if ("programming".equals(type)) {
			notebook = new LAThinkPad();
		} else if ("fun".equals(type)) {
			notebook = new LAMcBook();
		}
		return notebook;
	}
	
}
