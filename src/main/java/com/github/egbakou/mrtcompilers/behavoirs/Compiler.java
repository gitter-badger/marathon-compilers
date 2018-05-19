/*
 * Copyright (C) 2018 LionCoding <laurent@dorkenooconsulting.com>
 * Contains fragments of code from zt-exec, rights owned
 * by Apache Software Foundation (ASF).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.egbakou.mrtcompilers.behavoirs;

import com.github.egbakou.mrtcompilers.MarathonCompiler;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Compiler strategy
 *
 * @author Laurent Egbakou
 * @since 1.0
 */
public interface Compiler {

    String compileInTiming(MarathonCompiler compiler, TimeUnit timeUnit, Long timeOut) throws InterruptedException, TimeoutException, IOException;

    String compileWithoutTiming(MarathonCompiler compiler) throws InterruptedException, TimeoutException, IOException;

}