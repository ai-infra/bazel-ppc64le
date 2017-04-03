// Copyright 2017 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.benchmark.codegenerator;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

/** Class that contains arguments for the java files generator. */
public class GeneratorOptions extends OptionsBase {

  @Option(
    name = "modify",
    defaultValue = "false",
    category = "generator",
    help = "if we modify the existing code (or generate new code)."
  )
  public boolean modificationMode;

  @Option(
    name = "output_dir",
    defaultValue = "",
    category = "generator",
    valueHelp = "path",
    help = "directory where we put generated code or modify the existing code."
  )
  public String outputDir;

  @Option(
    name = "a_few_files",
    defaultValue = "false",
    category = "generator",
    help = "if we generate a package with a few files."
  )
  public boolean aFewFiles;

  @Option(
    name = "many_files",
    defaultValue = "false",
    category = "generator",
    help = "if we generate a package with many files."
  )
  public boolean manyFiles;

  @Option(
    name = "long_chained_deps",
    defaultValue = "false",
    category = "generator",
    help = "if we generate a package with long chained dependencies."
  )
  public boolean longChainedDeps;

  @Option(
    name = "parallel_deps",
    defaultValue = "false",
    category = "generator",
    help = "if we generate a package with parallel dependencies."
  )
  public boolean parallelDeps;
}
