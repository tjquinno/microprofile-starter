/*
 * Copyright (c) 2017-2021 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   2018-09-29 - Rudy De Busscher
 *      Initially authored in Atbash Jessie
 */
package org.eclipse.microprofile.starter.spi;

import org.eclipse.microprofile.starter.core.artifacts.BuildToolCreator;
import org.eclipse.microprofile.starter.core.artifacts.DirectoryCreator;
import org.eclipse.microprofile.starter.core.artifacts.MavenCreator;
import org.eclipse.microprofile.starter.core.artifacts.TemplateEngine;
import org.eclipse.microprofile.starter.core.model.JessieModel;
import org.eclipse.microprofile.starter.core.model.OptionValue;

import javax.inject.Inject;
import java.util.Map;

/**
 *
 */

public abstract class AbstractAddon implements JessieAddon {

    protected Map<String, OptionValue> options;
    protected Map<String, String> defaultOptions;

    @Inject
    protected DirectoryCreator directoryCreator;

    @Inject
    protected TemplateEngine templateEngine;

    @Override
    public final void addonOptions(Map<String, OptionValue> options) {
        this.options = options;
    }

    @Override
    public final void validate(JessieModel model) {
        validateModel(model);
    }

    protected void validateModel(JessieModel model) {

    }

    protected final String getResourceDirectory(JessieModel model, boolean mainProject) {
        return model.getDirectory(mainProject) + "/" + MavenCreator.SRC_MAIN_RESOURCES;
    }

    protected final String getJavaApplicationRootPackage(JessieModel model) {
        return BuildToolCreator.SRC_MAIN_JAVA + "/" + directoryCreator.createPathForGroupAndArtifact(model.getMaven());
    }

}
