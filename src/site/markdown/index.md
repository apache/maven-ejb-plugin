---
title: Introduction
author: 
  - Stephane Nicoll
  - snicoll@apache.org
  - Pete Marvin King
date: 2015-11-11
---

<!--
Licensed to the Apache Software Foundation (ASF) under one
or more contributor license agreements.  See the NOTICE file
distributed with this work for additional information
regarding copyright ownership.  The ASF licenses this file
to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance
with the License.  You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an
"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, either express or implied.  See the License for the
specific language governing permissions and limitations
under the License.
-->

# Apache Maven EJB Plugin
This plugin generates the Java Enterprise JavaBean (EJB) JAR and the associated ejb-client JAR.

## Goals Overview

Maven uses the [ejb:ejb](./ejb-mojo.html) goal for projects with the `ejb` package type.

## Usage

You can find the general usage instructions on the [usage page](./usage.html). The examples below describe more specific use cases.

If you have questions about the plugin, read the [FAQ](./faq.html) or contact the [user mailing list](./mailing-lists.html).

The mailing list archives can contain an answer from an older thread. You can also search the [mail archive](./mailing-lists.html).

If the plugin lacks a feature or has a defect, create a feature request or a bug report. Submit the request in the [issue tracker](./issue-management.html).

When you create a new issue, describe the problem completely. Attach complete debug logs, POMs, or small demo projects to the issue.

The developers must reproduce the problem to fix the bug. Patches are welcome.

Contributors can check out the project from the [source repository](./scm.html). They will find more information in the [guide to helping with Maven](/guides/development/guide-helping.html).

**Important Note:** Version 3.0.0 removed all user properties. You cannot use a property on the command line to configure maven-ejb-plugin. You must configure the plugin in the `pom.xml` file instead.

## Examples

To understand some usages of the Maven EJB Plugin, read the following examples:

- [Filter the deployment descriptor](./examples/filter-deployment-descriptor.html)
- [Generating an EJB client](./examples/generating-ejb-client.html)
- [Using the ejb-client as a dependency](./examples/ejb-client-dependency.html)
## Related Links

- [How to configure the archive, including its manifest](/shared/maven-archiver/index.html)