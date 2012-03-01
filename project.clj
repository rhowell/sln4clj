(defproject slns4clj "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.clojure/tools.trace "0.7.1"]]
  :repl-port 25976
  :repositories [["java.net" "http://download.java.net/maven/2"]
                 ["sonatype"
                  {:url "http://oss.sonatype.org/content/repositories/releases"
                   :snapshots false
                   :releases {:checksum :fail
                              :update :always}}]]
  :main slns4clj.core)
