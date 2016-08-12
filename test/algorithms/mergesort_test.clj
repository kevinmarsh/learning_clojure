(ns algorithms.mergesort-test
  (:require [clojure.test :refer :all]
            [algorithms.mergesort :refer :all]))

(deftest mergesort-integer-test
  (testing "empty"
    (is (= (mergesort []) [])))
  (testing "one element"
    (is (= (mergesort [1]) [1])))
  (testing "two right order"
    (is (= (mergesort [1 2]) [1 2])))
  (testing "two wrong order"
    (is (= (mergesort [2 1]) [1 2])))
  (testing "even number elements"
    (is (= (mergesort [2 3 1 4]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (mergesort [5 2 3 1 4]) [1 2 3 4 5]))))

(deftest split-middle-test
  (testing "empty"
    (is (= (split-middle []) [[] []])))
  (testing "one element"
    (is (= (split-middle [1]) [[1] []])))
  (testing "even number elements"
    (is (= (split-middle [1 2 3 4]) [[1 2] [3 4]])))
  (testing "odd number elements"
    (is (= (split-middle [1 2 3 4 5]) [[1 2 3] [4 5]]))))

(deftest mysort-test
  (testing "empty"
    (is (= (mysort []) [])))
  (testing "one element"
    (is (= (mysort [1]) [1])))
  (testing "even number elements"
    (is (= (mysort [1 4 2 3]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (mysort [4 5 1 3 2]) [1 2 3 4 5]))))

(deftest mymerge-test
  (testing "empty"
    (is (= (mymerge [] []) [])))
  (testing "one element and empty"
    (is (= (mymerge [1] []) [1])))
  (testing "even number elements"
    (is (= (mymerge [1 4] [2 3]) [1 2 3 4])))
  (testing "odd number elements"
    (is (= (mymerge [1 2 3] [3 5]) [1 2 3 3 5])))
  (testing "weird ordering"
    (is (= (mymerge [3 1 7 9] [2 4 6 5 8]) [2 3 1 4 6 5 7 8 9]))))