/*
 * Copyright (C) 2018 Egbakou <laurent@dorkenooconsulting.com>
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
package com.github.egbakou.mrtcompilers.complex;

import com.github.egbakou.mrtcompilers.MarathonCompiler;
import com.github.egbakou.mrtcompilers.behavoirs.CompiledLanguage;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.github.egbakou.mrtcompilers.util.CmdFileReader.loadPropertiesFile;
import static com.github.egbakou.mrtcompilers.util.Utility.outputFileName;

/**
 * C# compiler.
 *
 * @author Laurent Egbakou
 * @since 1.0
 */
public class CSharpCompiler extends CompiledLanguage implements CommonCompilerActions {

    /**
     * Default Constructor.
     */
    public CSharpCompiler() {
    }


    @Override
    public String compileWithoutTiming(String fileName)
            throws InterruptedException, TimeoutException, IOException {
        try {
            this.command(loadPropertiesFile().getString("cSharp.compile") + " " + fileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return super.compileWithoutTiming().trim();
    }


    @Override
    public String compileInTiming(String fileName, TimeUnit timeUnit, Long timeOut)
            throws InterruptedException, TimeoutException, IOException {
        try {
            this.command(loadPropertiesFile().getString("cSharp.compile") + " " + fileName);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return super.compileInTiming(timeUnit, timeOut).trim();
    }


    @Override
    public String runWithoutTiming(String fileName)
            throws InterruptedException, IOException, TimeoutException {
        try {
            this.command(loadPropertiesFile().getString("cSharp.run") + " " + outputFileName(fileName));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return super.runWithoutTiming().trim();
    }


    @Override
    public String runInTiming(String fileName, TimeUnit timeUnit, Long timeOut)
            throws InterruptedException, IOException, TimeoutException {
        try {
            this.command(loadPropertiesFile().getString("cSharp.run") + " " + outputFileName(fileName));
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        return super.runInTiming(timeUnit, timeOut).trim();
    }


    @Override
    public String compileAndRunWithoutTiming(String fileName)
            throws InterruptedException, TimeoutException, IOException {
        String compileCommand;
        String executeCommand;
        String executeResullt = null;
        try {
            compileCommand = loadPropertiesFile().getString("cSharp.compile") + " " + outputFileName(fileName);
            executeCommand = loadPropertiesFile().getString("cSharp.run") + " " + outputFileName(fileName);
            executeResullt = super.compileAndRunWithoutTiming(compileCommand, executeCommand).trim();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return executeResullt;
    }


    @Override
    public String compileAndRunInTiming(String fileName, TimeUnit timeUnit, Long timeOut)
            throws InterruptedException, TimeoutException, IOException {
        String compileCommand;
        String executeCommand;
        String executeResullt = null;
        try {
            compileCommand = loadPropertiesFile().getString("cSharp.compile") + " " + outputFileName(fileName);
            executeCommand = loadPropertiesFile().getString("cSharp.run") + " " + outputFileName(fileName);
            executeResullt = super.compileAndRunIntiming(compileCommand, executeCommand, timeUnit, timeOut).trim();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return executeResullt;
    }


    /**
     * Set directory where file are stored.
     *
     * @param directory a directory.
     * @return current C# compiler with new directory value.
     */
    @Override
    public CSharpCompiler directory(File directory) {
        return (CSharpCompiler) super.directory(directory);
    }


}
