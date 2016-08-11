(ns fourclojure.cartesian-product
  (:require [clojure.set]))

;; http://www.4clojure.com/problem/90
;; 4Clojure has the restriction that whatever you pass in as `__` is what get's
;; executed, this leads for coding gymnastics to get it working. My answer on the
;; site was:

(defn my-fourclojure-cartesian-product [x y]
  (let [cartesian_product_iter (fn [set1 set2 result]
    (if (empty? set1)
      (set result)
      (let [new_result (clojure.set/union (map #(identity [(first set1) %]) set2)
                                          result)]
        (recur (rest set1) set2 new_result))))]
    (let [cartesian_product (fn [set1 set2]
      (cartesian_product_iter set1 set2 #{}))]
      (cartesian_product x y))))

;; However reomving that restriction my soultion is more nicely split up into:

(defn vec-fn-builder [col]
   #(vector (first col) %))

(defn cartesian-product-iter [set1 set2 result]
  (if (empty? set1)
    (set result)
    (let [new-result (clojure.set/union (map (vec-fn-builder set1) set2) result)]
      (recur (rest set1) set2 new-result))))

(defn cartesian-product [set1 set2]
  (cartesian-product-iter set1 set2 #{}))

;; Looking at other people's solutions, it appears this is just baked into the language:

(defn others-fourclojure-cartesian-product [x y]
  (set (for [a x b y] [a b])))