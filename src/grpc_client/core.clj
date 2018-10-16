(ns grpc-client.core
  (:import (io.grpc 
            ServerBuilder 
            Server 
            BindableService)
           (rpprotobuf.listing_service 
            SearchServiceGrpc
            CriteriaOuterClass$Criteria
            SearchRequestOuterClass$SearchRequest 
            SearchResponseOuterClass$SearchResponse 
            SearchResponseOuterClass$SearchResponse$Status)
           (io.grpc.stub StreamObserver)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))




(def grpc-search-client 
  (SearchServiceGrpc/newBlockingStub
   (-> (io.grpc.ManagedChannelBuilder/forAddress "localhost" (int 8280))
       (.usePlaintext true)
       .build)))

(defn build-criteria
  [city state]
  (-> (CriteriaOuterClass$Criteria/newBuilder)
      (.setCitySlug city)
      (.setStateSlug state)))


(defn search
  [city state]
  (let [criteria (build-criteria city state)]
    (.search grpc-search-client (-> (SearchRequestOuterClass$SearchRequest/newBuilder)
                                    (.setCriteria criteria)
                                    .build))))
