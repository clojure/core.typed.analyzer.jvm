{:namespaces
 ({:doc nil,
   :name "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm/index.html",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj"}),
 :vars
 ({:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "->ExceptionThrown",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L457",
   :line 457,
   :var-type "function",
   :arglists ([e ast]),
   :doc
   "Positional factory function for class clojure.core.typed.analyzer.jvm.ExceptionThrown.",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/->ExceptionThrown"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "analyze",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L423",
   :line 423,
   :var-type "function",
   :arglists ([form] [form env] [form env opts]),
   :doc
   "Analyzes a clojure form using tools.analyzer augmented with the JVM specific special ops\nand returns its AST, after running #'run-passes on it.\n\nIf no configuration option is provides, analyze will setup tools.analyzer using the extension\npoints declared in this namespace.\n\nIf provided, opts should be a map of options to analyze, currently the only valid\noptions are :bindings and :passes-opts (if not provided, :passes-opts defaults to the\nvalue of `default-passes-opts`).\nIf provided, :bindings should be a map of Var->value pairs that will be merged into the\ndefault bindings for tools.analyzer, useful to provide custom extension points.\nIf provided, :passes-opts should be a map of pass-name-kw->pass-config-map pairs that\ncan be used to configure the behaviour of each pass.\n\nE.g.\n(analyze form env {:bindings  {#'ana/macroexpand-1 my-mexpand-1}})",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/analyze"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "analyze+eval",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L480",
   :line 480,
   :var-type "function",
   :arglists
   ([form]
    [form env]
    [form
     env
     {:keys
      [additional-gilardi-condition
       eval-fn
       annotate-do
       statement-opts-fn
       stop-gildardi-check
       analyze-fn],
      :or
      {additional-gilardi-condition (fn [form env] true),
       eval-fn eval-ast,
       annotate-do (fn [a _ _] a),
       statement-opts-fn identity,
       stop-gildardi-check (fn [form env] false),
       analyze-fn analyze},
      :as opts}]),
   :doc
   "Like analyze but evals the form after the analysis and attaches the\nreturned value in the :result field of the AST node.\n\nIf evaluating the form will cause an exception to be thrown, the exception\nwill be caught and wrapped in an ExceptionThrown object, containing the\nexception in the `e` field and the AST in the `ast` field.\n\nThe ExceptionThrown object is then passed to `handle-evaluation-exception`,\nwhich by defaults throws the original exception, but can be used to provide\na replacement return value for the evaluation of the AST.\n\nUnrolls `do` forms to handle the Gilardi scenario.\n\nUseful when analyzing whole files/namespaces.",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/analyze+eval"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "create-var",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L208",
   :line 208,
   :var-type "function",
   :arglists ([sym {:keys [ns]}]),
   :doc
   "Creates a Var for sym and returns it.\nThe Var gets interned in the env namespace.",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/create-var"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "default-passes",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L134",
   :line 134,
   :var-type "var",
   :arglists nil,
   :doc
   "Set of passes that will be run by default on the AST by #'run-passes",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/default-passes"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "default-passes-opts",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L178",
   :line 178,
   :var-type "var",
   :arglists nil,
   :doc "Default :passes-opts for `analyze`",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/default-passes-opts"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "macroexpand-1",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L85",
   :line 85,
   :var-type "function",
   :arglists ([form] [form env]),
   :doc
   "If form represents a macro form or an inlineable function, returns its expansion,\nelse returns form.",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/macroexpand-1"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "resolve-ns",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L187",
   :line 187,
   :var-type "function",
   :arglists ([ns-sym {:keys [ns]}]),
   :doc "Resolves the ns mapped by the given sym in the global env",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/resolve-ns"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "resolve-sym",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L200",
   :line 200,
   :var-type "function",
   :arglists ([sym {:keys [ns], :as env}]),
   :doc "Resolves the value mapped by the given sym in the global env",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/resolve-sym"}
  {:raw-source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/raw/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :name "specials",
   :file "src/main/clojure/clojure/core/typed/analyzer/jvm.clj",
   :source-url
   "https://github.com/clojure/core.typed.analyzer.jvm/blob/b5d7164bdde2177873c98ddf209abe873faf10fc/src/main/clojure/clojure/core/typed/analyzer/jvm.clj#L33",
   :line 33,
   :var-type "var",
   :arglists nil,
   :doc "Set of the special forms for clojure in the JVM",
   :namespace "clojure.core.typed.analyzer.jvm",
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/specials"}
  {:name "ExceptionThrown",
   :var-type "type",
   :namespace "clojure.core.typed.analyzer.jvm",
   :arglists nil,
   :wiki-url
   "https://clojure.github.io/core.typed.analyzer.jvm//index.html#clojure.core.typed.analyzer.jvm/ExceptionThrown",
   :source-url nil,
   :raw-source-url nil,
   :file nil})}
