package NotebookFactory;

public abstract class NotebookStore {

	public Notebook prepareForSaleNotebook(String type) {
		Notebook notebook;
		notebook = createNotebook(type);
		notebook.complete();
		notebook.collect();
		notebook.estimatePrice();
		return notebook;
	}
	
	abstract Notebook createNotebook(String type);
}
