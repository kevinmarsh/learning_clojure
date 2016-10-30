(ns algorithms.binary-search-test
  (:require [clojure.test :refer :all]
            [algorithms.binary-search :refer :all]))

(deftest int-average-test
  (testing "one element"
    (is (= (int-average 1) 1)))
  (testing "two elements"
    (is (= (int-average 1 3) 2)))
  (testing "two elements next to each other"
    (is (= (int-average 1 2) 1)))
  (testing "multiple elements"
    (is (= (int-average 2 4 6) 4)))
  (testing "multiple elements spaced"
    (is (= (int-average 2 4 6 7) 4))))

(deftest binary-search-test
  (testing "empty"
    (is (= (binary-search [] 1) nil)))
  (testing "one element match"
    (is (= (binary-search [1] 1) 0)))
  (testing "two match"
    (is (= (binary-search [1 2] 2) 1)))
  (testing "no match"
    (is (= (binary-search [1 2] 3) nil)))
  (testing "even number elements"
    (is (= (binary-search [1 2 3 4 5 6 7 8] 3) 2)))
  (testing "odd number elements"
    (is (= (binary-search [1 2 3 4 5 6 7 8 9] 9) 8)))
  (testing "large number elements"
    (is (= (binary-search (vec (range 10001)) 10000) 10000))))
