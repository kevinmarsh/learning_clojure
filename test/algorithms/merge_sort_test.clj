(ns algorithms.merge-sort-test
  (:require [clojure.test :refer :all]
            [algorithms.merge-sort :refer :all]))

(deftest merge-sort-integer-test
  (testing "empty"
    (is (= (merge-sort []) [])))
  (testing "one element"
    (is (= (merge-sort [1]) [1])))
  (testing "two right order"
    (is (= (merge-sort [1 2]) [1 2])))
  (testing "two wrong order"
    (is (= (merge-sort [2 1]) [1 2])))
  (testing "even number elements"
    (is (= (merge-sort [2 3 1 4]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (merge-sort [5 2 3 1 4]) [1 2 3 4 5]))))

(deftest split-middle-test
  (testing "empty"
    (is (= (split-middle []) [[] []])))
  (testing "one element"
    (is (= (split-middle [1]) [[1] []])))
  (testing "even number elements"
    (is (= (split-middle [1 2 3 4]) [[1 2] [3 4]])))
  (testing "odd number elements"
    (is (= (split-middle [1 2 3 4 5]) [[1 2 3] [4 5]]))))

(deftest merge-seqs-test
  (testing "empty"
    (is (= (merge-seqs [] []) [])))
  (testing "one element and empty"
    (is (= (merge-seqs [1] []) [1])))
  (testing "even number elements"
    (is (= (merge-seqs [1 4] [2 3]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (merge-seqs [1 2 3] [3 5]) [1 2 3 3 5])))
  (testing "weird ordering"
    (is (= (merge-seqs [3 1 7 9] [2 4 6 5 8]) [2 3 1 4 6 5 7 8 9]))))
