# core.typed.analyzer.jvm

<a href='https://typedclojure.org'><img src='images/part-of-typed-clojure-project.png'></a>

Analyzer for JVM Clojure, tuned for consumption by an optional type checker.

## DEPRECATION NOTICE

This repository is DEPRECATED and development has been moved
to the [core.typed](https://github.com/clojure/core.typed) monorepo.
Please follow [these](https://github.com/clojure/core.typed/blob/master/UPGRADING.md#upgrading-from-07x-to-monorepo)
to upgrade.

## Releases and Dependency Information

Latest stable release is 0.7.1.

* [All Released Versions](https://search.maven.org/search?q=g:org.clojure%20AND%20a:core.typed.analyzer.jvm)

[deps.edn](https://clojure.org/reference/deps_and_cli) dependency information:

```clj
  org.clojure/core.typed.analyzer.jvm {:mvn/version "0.7.1"}
 ```

[Leiningen](https://github.com/technomancy/leiningen) dependency information:

```clojure
[org.clojure/core.typed.analyzer.jvm "0.7.1"]
```

[Maven](https://maven.apache.org/) dependency information:

```XML
<dependency>
  <groupId>org.clojure</groupId>
  <artifactId>core.typed.analyzer.jvm</artifactId>
  <version>0.7.1</version>
</dependency>
```

## Differences from tools.analyzer.jvm

core.typed.analyzer.jvm is a heavily modified variant of tools.analyzer.jvm.
If you're familiar with the latter, here's what this library does differently.

- Adds an `:unanalyzed` AST node that just holds a `:form` and `:env`.
- Forms are analyzed lazily, with `:unanalyzed` nodes being used for immediate children.
- `:unanalyzed` nodes support a `:clojure.core.typed.analyzer/config` entry which will be associated
  onto whatever node it becomes when analyzed.
- `clojure.tools.analyzer.env` is not used.
- `resolve-{sym,ns}` are now dynamic variables that are implemented for each platform.
- `run-passes` only supports a single pass
- `uniquify-locals` is a default pass that is compatible with `:unanalyzed` nodes
- Gilardi scenario can be (carefully) managed (see `clojure.core.typed.analyzer.jvm.gilardi-test` for a type system example)

## License

Copyright © Ambrose Bonnaire-Sergeant, Rich Hickey & contributors.

Licensed under the EPL (see the file epl-v10.html).
