/*
 * Copyright 2016 the original author or authors.
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
package org.springframework.cloud.stream.app.transform.javacompiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Holder for the results of compilation. If compilation was successful the set
 * of classes that resulted from compilation will be available. If compilation
 * was not successful the error messages should provide information about why.
 * Note that compilation may succeed and yet there will still be informational or
 * warning messages collected.
 * 
 * @author Andy Clement
 */
public class CompilationResult {

	private boolean successfulCompilation;

	List<CompilationMessage> compilationMessages = new ArrayList<>();

	List<Class<?>> compiledClasses = new ArrayList<>();

	public CompilationResult(boolean successfulCompilation) {
		this.successfulCompilation = successfulCompilation;
	}

	public boolean wasSuccessful() {
		return successfulCompilation;
	}

	public List<Class<?>> getCompiledClasses() {
		return compiledClasses;
	}
	
	public List<CompilationMessage> getCompilationMessages() {
		return Collections.unmodifiableList(compilationMessages);
	}

	public void recordCompilationMessage(CompilationMessage compilationMessage) {
		this.compilationMessages.add(compilationMessage);
	}

	public void setCompiledClasses(List<Class<?>> compiledClasses) {
		this.compiledClasses = compiledClasses;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Compilation result: #classes="+compiledClasses.size()+"  #messages="+compilationMessages.size()+"\n");
		s.append("Compiled classes:\n").append(compiledClasses).append("\n");
		s.append("Compilation messages:\n").append(compilationMessages).append("\n");
		return s.toString();
	}

}
