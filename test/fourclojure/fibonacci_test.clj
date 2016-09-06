(ns fourclojure.fibonacci-test
  (:require [clojure.test :refer :all]
            [fourclojure.fibonacci :refer :all]))

(deftest first-attempt-fibonacci-test
  (testing "first"
    (is (= (first-attempt-fibonacci 3) '(1 1 2))))
  (testing "second"
    (is (= (first-attempt-fibonacci 6) '(1 1 2 3 5 8))))
  (testing "third"
    (is (= (first-attempt-fibonacci 8) '(1 1 2 3 5 8 13 21)))))

(deftest start-fibonacci-test
  (testing "first"
    (is (= (start-fibonacci 3) '(1 1 2))))
  (testing "second"
    (is (= (start-fibonacci 6) '(1 1 2 3 5 8))))
  (testing "third"
    (is (= (start-fibonacci 8) '(1 1 2 3 5 8 13 21)))))