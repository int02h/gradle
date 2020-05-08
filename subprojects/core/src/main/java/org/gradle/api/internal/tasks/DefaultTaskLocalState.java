/*
 * Copyright 2017 the original author or authors.
 *
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
 */

package org.gradle.api.internal.tasks;

import org.gradle.api.NonNullApi;
import org.gradle.api.file.ConfigurableFileCollection;
import org.gradle.api.file.FileCollection;
import org.gradle.api.internal.file.FileCollectionFactory;


@NonNullApi
public class DefaultTaskLocalState implements TaskLocalStateInternal {
    private final TaskMutator taskMutator;
    private final ConfigurableFileCollection registeredPaths;

    public DefaultTaskLocalState(TaskMutator taskMutator, FileCollectionFactory fileCollectionFactory) {
        this.taskMutator = taskMutator;
        this.registeredPaths = fileCollectionFactory.configurableFiles("localState");
    }

    @Override
    public void register(final Object... paths) {
        taskMutator.mutate("TaskLocalState.register(Object...)", () -> {
            registeredPaths.from(paths);
        });
    }

    @Override
    public FileCollection getRegisteredPaths() {
        return registeredPaths;
    }
}
