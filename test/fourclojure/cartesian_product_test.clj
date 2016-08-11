(ns fourclojure.cartesian-product-test
  (:require [clojure.test :refer :all]
            [fourclojure.cartesian-product :refer :all]))

(deftest my-cartesian-product-test
  (testing "first"
    (is (= (cartesian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
           #{["ace" "♠"] ["ace" "♥"] ["ace" "♦"] ["ace" "♣"] ["king" "♠"] ["king" "♥"] ["king" "♦"] ["king" "♣"] ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})))
  (testing "second"
    (is (= (cartesian-product #{1 2 3} #{4 5})
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})))
  (testing "third"
    (is (= 300
           (count (cartesian-product (into #{} (range 10))
                                     (into #{} (range 30))))))))

(deftest others-cartesian-product-test
  (testing "first"
    (is (= (others-fourclojure-cartesian-product #{"ace" "king" "queen"} #{"♠" "♥" "♦" "♣"})
           #{["ace" "♠"] ["ace" "♥"] ["ace" "♦"] ["ace" "♣"] ["king" "♠"] ["king" "♥"] ["king" "♦"] ["king" "♣"] ["queen" "♠"] ["queen" "♥"] ["queen" "♦"] ["queen" "♣"]})))
  (testing "second"
    (is (= (others-fourclojure-cartesian-product #{1 2 3} #{4 5})
           #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})))
  (testing "third"
    (is (= 300
           (count (others-fourclojure-cartesian-product (into #{} (range 10))
                                                        (into #{} (range 30))))))))
