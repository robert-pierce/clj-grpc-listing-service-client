(defproject grpc-client "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-protoc "0.5.0"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 ;; gRPC stuff
                 [clojusc/protobuf "3.5.1-v1.1"]
                 [io.grpc/grpc-netty-shaded "1.15.1" :exclusions [io.grpc/grpc-core]]
                 [io.grpc/grpc-protobuf "1.15.1"]
                 [io.grpc/grpc-stub "1.15.1"]
                 [javax.annotation/javax.annotation-api "1.3.2"]
]
  :proto-source-paths ["resources/proto"]
  :proto-target-path "proto"
  :protoc-version "3.6.1"
  :protoc-grpc {:version "1.15.1"}
  :java-source-paths ["proto"]
  :profiles {})
