(ns fourclojure.pascals-triangle-test
  (:require [clojure.test :refer :all]
            [fourclojure.pascals-triangle :refer :all]))

(deftest pascals-triangle-test
  (testing "first"
    (is (= (pascals-triangle 1) [1])))
  (testing "second"
    (is (= (map pascals-triangle (range 1 6)) [
         [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])))
  (testing "third"
    (is (= (pascals-triangle 11) [1 10 45 120 210 252 210 120 45 10 1]))))
