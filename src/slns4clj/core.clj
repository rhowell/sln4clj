(ns slns4clj.core
  (use [clojure.test])
  (require [clojure.string]
           [clojure.set]))

; Problem 1
(with-test
  (def prb-1 true)
  (is (= prb-1 true)))

; Problem 2
(with-test
  (def prb-2 4)
  (is (= (- 10 (* 2 3)) prb-2)))

; Problem 3
(with-test
  (def prb-3 "HELLO WORLD")
  (is (= prb-3 (.toUpperCase "hello world"))))

; Problem 4
; __ = :a :b :c
(test
  (is (= (list :a :b :c) '(:a :b :c))))

; Problem 5
(with-test
  (def prb-5 '(1 2 3 4))
  (is (= prb-5 (conj '(2 3 4) 1)))
  (is (= prb-5 (conj '(3 4) 2 1))))

; Problem 6
; __ = :a :b :c
(test
  (is (= [:a :b :c] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))))

; Problem 7 
(with-test
  (def prb-7 [1 2 3 4])
    (is (= prb-7 (conj [1 2 3] 4)))
    (is (= prb-7 (conj [1 2] 3 4))))

; Problem 8
(with-test
  (def prb-8 #{:a :b :c :d})
  (is (= prb-8 (set '(:a :a :b :c :c :c :c :d :d))))
  (is (= prb-8 (clojure.set/union #{:a :b :c} #{:b :c :d}))))

; Problem 9
(with-test
  (def prb-9 2)
  (is (= #{1 2 3 4} (conj #{1 4 3} prb-9))))

; Problem 10
(with-test
  (def prb-10 20)
  (is (= prb-10 ((hash-map :a 10, :b 20, :c 30) :b)))
  (is (= prb-10 (:b {:a 10, :b 20, :c 30}))))

; Problem 11
(with-test
  (def prb-11 {:b 2})
  (is (= {:a 1, :b 2, :c 3} (conj {:a 1} prb-11 [:c 3]))))

; Problem 12
(with-test
  (def prb-12 3)
  (is (= prb-12 (first '(3 2 1))))
  (is (= prb-12 (second [2 3 4])))
  (is (= prb-12 (last (list 1 2 3)))))

; Problem 13
(with-test
  (def prb-13 [20 30 40])
  (is (= prb-13 (rest [10 20 30 40]))))

; Problem 14
(with-test
  (def prb-14 8)
  (is (= prb-14 ((fn add-five [x] (+ x 5)) 3)))
  (is (= prb-14 ((fn [x] (+ x 5)) 3)))
  (is (= prb-14 (#(+ % 5) 3)))
  (is (= prb-14 ((partial + 5) 3))))

; Problem 15
; __ = * 2
(test
  (is (= (* 2 2) 4))
  (is (= (* 2 3) 6))
  (is (= (* 2 11) 22))
  (is (= (* 2 7) 14)))

; Problem 16
(with-test
  (def prb-16 (fn [name] (str "Hello, " name "!")))
  (is (= (prb-16 "Dave") "Hello, Dave!"))
  (is (= (prb-16 "Jenn") "Hello, Jenn!"))
  (is (= (prb-16 "Rhea") "Hello, Rhea!")))

; Problem 135
(with-test
	(def prb-135 
  (fn [& args]
    (if (>= (count args) 3)
      (let [[l op r & xs] args]
        (recur (conj xs (op l r) )))
      (first args))))
  (is (= 7  (prb-135 2 + 5)))
  (is (= 42 (prb-135 38 + 48 - 2 / 2)))
  (is (= 8  (prb-135 10 / 2 - 1 * 2)))
  (is (= 72 (prb-135 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))))


; Problem 150
(with-test
  (def prb-150 
    (fn [n]
      (let [is-palindrom? (fn [x] 
                            (let
                              [strx (str x)
                               size (int (/ (count strx) 2))
                               lft (take size strx)
                               rht (take size (reverse strx))]
                              (= lft rht)))
            sub-generator (fn [x]
                            (if (sequential? x)
                              (let [[half is-odd?] x
                                    rollover? (apply = (conj half \9))
                                    half (seq (str (inc (bigint (apply str half)))))]
                                (if rollover?
                                  (if is-odd?
                                    [(drop-last half) (not is-odd?)]
                                    [half (not is-odd?)])
                                  [half is-odd?]))
                              (let [seqx (str x) ; Number as a sequence
                                    size (count seqx) ; Number of digits in number
                                    half (take (/ size 2) seqx)] ; First half of the number
                                (if (is-palindrom? x)
                                  [(take (/ size 2) seqx) (odd? size)]
                                  (if (> (bigint (apply str half)) ; First half is larger than second half
                                         (bigint (apply str (take (/ size 2) (reverse seqx)))))
                                    [half (odd? size)]
                                    [(seq (str (inc (bigint (apply str half))))) (odd? size)])))))]
        (map #(let [[half is-odd?] %1]
                (bigint (apply str (concat half 
                                           (if is-odd?
                                             (rest (reverse half))
                                             (reverse half))))))
             (next (iterate sub-generator n))))))
  (is (= (take 26 (prb-150 0))
         [0 1 2 3 4 5 6 7 8 9
          11 22 33 44 55 66 77 88 99
          101 111 121 131 141 151 161]))
  (is (= (take 16 (prb-150 162))
         [171 181 191 202
          212 222 232 242
          252 262 272 282
          292 303 313 323]))
  (is (= (take 6 (prb-150 1234550000))
         [1234554321 1234664321 1234774321
          1234884321 1234994321 1235005321]))
  (is (= (first (prb-150 (* 111111111 111111111)))
         (* 111111111 111111111)))
  (is (= (set (take 199 (prb-150 0)))
         (set (map #(first (prb-150 %)) (range 0 10000)))))
  (is (= true
         (apply < (take 6666 (prb-150 9999999)))))
  (is (= (nth (prb-150 0) 10101)
         9102019)))

