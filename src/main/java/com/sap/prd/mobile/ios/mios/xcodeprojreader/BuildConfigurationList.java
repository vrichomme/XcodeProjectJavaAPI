/*
 * #%L
 * xcode-project-reader
 * %%
 * Copyright (C) 2012 SAP AG
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.sap.prd.mobile.ios.mios.xcodeprojreader;

public class BuildConfigurationList extends Element
{
  public BuildConfigurationList(ProjectFile projectFile)
  {
    this(projectFile, projectFile.createDict());
  }

  BuildConfigurationList(ProjectFile projectFile, Dict buildConfigurationList)
  {
    super(projectFile, buildConfigurationList);
  }

  public String getDefaultConfigurationName()
  {
    return getString("defaultConfigurationName");
  }

  public ReferenceArray<BuildConfiguration> getBuildConfigurations()
  {
    return new ReferenceArray<BuildConfiguration>(getProjectFile(),
          getOrCreateAndSetArray("buildConfigurations"), new ElementFactory<BuildConfiguration>() {
            @Override
            public BuildConfiguration create(ProjectFile projectFile, Dict dict)
            {
              return new BuildConfiguration(projectFile, dict);
            }
          });
  }
}
