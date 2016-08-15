(ns fourclojure.least-common-multiple-test
  (:require [clojure.test :refer :all]
            [fourclojure.least-common-multiple :refer :all]))

(deftest simple-least-common-multiple-test
  (testing "first"
    (is (= (simple-least-common-multiple 2 3) 6)))
  (testing "second"
    (is (= (simple-least-common-multiple 5 3 7) 105))))

(deftest least-common-multiple-test
  (testing "first"
    (is (= (least-common-multiple 2 3) 6)))
  (testing "second"
    (is (= (least-common-multiple 5 3 7) 105)))
  (testing "third"
    (is (= (least-common-multiple 1/3 2/5) 2)))
  (testing "fourth"
    (is (= (least-common-multiple 3/4 1/6) 3/2)))
  (testing "fifth"
    (is (= (least-common-multiple 7 5/7 2 3/5) 210))))
