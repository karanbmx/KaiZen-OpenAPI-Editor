package com.reprezen.swagedit.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.reprezen.swagedit.editor.SwaggerEditor;

public class SwagEditNewWizard extends Wizard implements INewWizard {

	private SwagEditNewWizardPage page;
	private IStructuredSelection selection;

	/**
	 * Constructor for SampleNewWizard.
	 */
	public SwagEditNewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	/**
	 * Adding the page to the wizard.
	 */
	public void addPages() {
		page = new SwagEditNewWizardPage(selection);
		addPage(page);
	}

	@Override
	public boolean performFinish() {
		final IFile file = page.createNewFile();
		if (file == null || !file.exists()) {
			return false;
		}

		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, SwaggerEditor.ID);
				} catch (PartInitException e) {}
			}
		});

		return true;
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
}