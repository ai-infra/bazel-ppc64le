// Copyright 2016 The Bazel Authors. All rights reserved.
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
package com.google.devtools.build.android.dexer;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;

import java.util.zip.ZipEntry;

class ZipEntryPredicates {

  public static Predicate<ZipEntry> isDirectory() {
    return new Predicate<ZipEntry>() {
      @Override
      public boolean apply(ZipEntry input) {
        return input.isDirectory();
      }
    };
  }

  public static Predicate<ZipEntry> suffixes(final String... suffixes) {
    return new Predicate<ZipEntry>() {
      @Override
      public boolean apply(ZipEntry input) {
        String filename = input.getName();
        for (String suffix : suffixes) {
          if (filename.endsWith(suffix)) {
            return true;
          }
        }
        return false;
      }
    };
  }

  public static Predicate<ZipEntry> classFileFilter(final ImmutableSet<String> classFileNames) {
    return new Predicate<ZipEntry>() {
      @Override
      public boolean apply(ZipEntry input) {
        String filename = input.getName();
        if (filename.endsWith(".class.dex")) {
          // Chop off file suffix generated by DexBuilder
          filename = filename.substring(0, filename.length() - ".dex".length());
        }
        return filename.endsWith(".class") && classFileNames.contains(filename);
      }
    };
  }

  private ZipEntryPredicates() {}
}
