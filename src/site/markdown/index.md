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
This plugin generates Java Enterprise JavaBean (EJB) file as well as the associated client jar.

## Goals Overview

[ejb:ejb](./ejb-mojo.html) - used by Maven for projects with `ejb` package type.

## Usage

General instructions on how to use the EJB Plugin can be found on the [usage page](./usage.html). Some more specific use cases are described in the examples given below.

In case you still have questions regarding the plugin's usage, please have a look at the [FAQ](./faq.html) and feel free to contact the [user mailing list](./mailing-lists.html). The posts to the mailing list are archived and could already contain the answer to your question as part of an older thread. Hence, it is also worth browsing/searching the [mail archive](./mailing-lists.html).

If you feel like the plugin is missing a feature or has a defect, you can fill a feature request or bug report in our [issue tracker](./issue-management.html). When creating a new issue, please provide a comprehensive description of your concern. Especially for fixing bugs it is crucial that the developers can reproduce your problem. For this reason, entire debug logs, POMs or most preferably little demo projects attached to the issue are very much appreciated. Of course, patches are welcome, too. Contributors can check out the project from our [source repository](./scm.html) and will find supplementary information in the [guide to helping with Maven](/guides/development/guide-helping.html).

Important Note: Starting with version 3.0.0 of the plugin all user properties have been removed which means you can't use a property on the command line anymore to configure maven-ejb-plugin. The configuration of the plugin has be done in the `pom.xml` file instead.

## Examples

To provide you with better understanding on some usages of the Maven EJB Plugin, you can take a look into the following examples:

- [Filter the deployment descriptor](./examples/filter-deployment-descriptor.html)
- [Generating an EJB client](./examples/generating-ejb-client.html)
- [Using the ejb-client as a dependency](./examples/ejb-client-dependency.html)
## Related Links

- [How to configure the archive, including its manifest](/shared/maven-archiver/index.html)
