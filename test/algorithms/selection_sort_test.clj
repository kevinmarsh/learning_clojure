(ns algorithms.selection-sort-test
  (:require [clojure.test :refer :all]
            [algorithms.selection-sort :refer :all]))

(deftest selection-sort-test
  (testing "empty"
    (is (= (selection-sort []) [])))
  (testing "one element"
    (is (= (selection-sort [1]) [1])))
  (testing "two elements"
    (is (= (selection-sort [2 1]) [1 2]))))
  (testing "three elements"
    (is (= (selection-sort [2 1 3]) [1 2 3])))
  (testing "large number elements"
    (is (= (selection-sort (shuffle (range 10))) (range 10))))
