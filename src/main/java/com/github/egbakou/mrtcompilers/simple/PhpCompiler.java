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
package com.github.egbakou.mrtcompilers.simple;

import com.github.egbakou.mrtcompilers.behavoirs.InterpretedLanguage;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.github.egbakou.mrtcompilers.util.CmdFileReader.loadPropertiesFile;

/**
 * PHP compiler.
 *
 * @author Laurent Egbakou
 * @since 1.0
 */
public class PhpCompiler extends InterpretedLanguage implements CommonInterpreterActions {


    /**
     * Default Constructor.
     */
    public PhpCompiler() {
    }

    /**
     * Execute file without timing. This method should be avoided
     * to prevent threads from blocking the execution of the file.
     *
     * @param fileName file name with extension.
     * @return the result of the execution.
     * @throws InterruptedException thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the activity.
     * @throws IOException          signals that an I/O exception of some sort has occurred.
     * @throws TimeoutException     exception thrown when a blocking operation times out.
     */
    @Override
    public String executewithoutTiming(String fileName) throws InterruptedException, IOException, TimeoutException {
        try {
            this.command(loadPropertiesFile().getString("php.run") + " " + fileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return super.executeWithoutTiming().trim();
    }

    /**
     * Execute file with timing constraints. This method is to be recommended.
     *
     * @param fileName file name with extension.
     * @param timeUnit a represents time durations at a given unit of
     *                 granularity and provides utility methods to convert across units,
     *                 and to perform timing and delay operations in these units
     * @param timeOut  timeout for running a process. If the process is running too
     *                 long a {@link TimeoutException} is thrown and the process is destroyed.
     * @return the result of the execution.
     * @throws InterruptedException thrown when a thread is waiting, sleeping, or otherwise occupied,
     *                              and the thread is interrupted, either before or during the activity.
     * @throws IOException          signals that an I/O exception of some sort has occurred.
     * @throws TimeoutException     exception thrown when a blocking operation times out.
     */
    @Override
    public String executeInTiming(String fileName, TimeUnit timeUnit, Long timeOut) throws InterruptedException, IOException, TimeoutException {
        try {
            this.command(loadPropertiesFile().getString("php.run") + " " + fileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return super.executeInTiming(timeUnit, timeOut).trim();
    }

    /**
     * Set directory where file are stored.
     *
     * @param directory a directory.
     * @return the compiler with new directory value.
     */
    @Override
    public PhpCompiler directory(File directory) {
        return (PhpCompiler) super.directory(directory);
    }
}
