/*******************************************************************************
 * Copyright (c) 2016 ModelSolv, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    ModelSolv, Inc. - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.reprezen.swagedit.openapi3.preferences;

import com.reprezen.swagedit.core.preferences.KaizenTemplatePreferences;
import com.reprezen.swagedit.openapi3.Activator;
import com.reprezen.swagedit.openapi3.editor.OpenApi3Editor;

public class OpenApiTemplatePreferences extends KaizenTemplatePreferences {

    public OpenApiTemplatePreferences() {
        super(new OpenApi3Editor.OpenApi3SourceViewerConfiguration(), Activator.getDefault().getPreferenceStore(),
                Activator.getDefault().getTemplateStore(), Activator.getDefault().getContextTypeRegistry());

    }

}
