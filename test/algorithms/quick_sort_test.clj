(ns algorithms.quick-sort-test
  (:require [clojure.test :refer :all]
            [algorithms.quick-sort :refer :all]))

(deftest quick-sort-integer-test
  (testing "empty"
    (is (= (quick-sort []) [])))
  (testing "one element"
    (is (= (quick-sort [1]) [1])))
  (testing "two right order"
    (is (= (quick-sort [1 2]) [1 2])))
  (testing "two wrong order"
    (is (= (quick-sort [2 1]) [1 2])))
  (testing "even number elements"
    (is (= (quick-sort [2 3 1 4]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (quick-sort [5 2 3 1 4]) [1 2 3 4 5]))))

