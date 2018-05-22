/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.touringmusician;


import android.graphics.Point;

import java.util.Iterator;

public class CircularLinkedList implements Iterable<Point> {

    private class Node {
        Point point;
        Node prev, next;
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/
        private Node(Point p) {
            point = p;
            prev = null;
            next = null;
        }
    }

    Node head;

    public void insertBeginning(Point p) {
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/


        // Create new point and insert it at the beginning
        Node beginning = new Node(p);
        if (head == null) {
            head.point = p;
            head.prev = head;
            head.next = head;
        }
        else {
            Node old = head.prev;
            beginning.next = head;
            beginning.prev = old;
            head.prev = beginning;
            old.next = beginning;
        }
    }

    private float distanceBetween(Point from, Point to) {
        return (float) Math.sqrt(Math.pow(from.y-to.y, 2) + Math.pow(from.x-to.x, 2));
    }

    public float totalDistance() {
        float total = 0;
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/
        if (head != null) {
            Node temp = head;
            while (temp.next != head) {
                // Distance between point of temp and the next point
                total += distanceBetween(temp.point, temp.next.point);
                temp = temp.next;
            }
        }
        return total;
    }

    public void insertNearest(Point p) {
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/

        Node temp = head;
        Node nearest = null;
        if (temp == null || temp.next == head) { // if the list is empty or it has only one node
            insertBeginning(p);
        }
        else { // traverse the list to find the smallest distance
            float nearestDist = Float.MAX_VALUE;
            while (temp.next != head) {
                float dist = distanceBetween(temp.point, p);
                if (dist < nearestDist) {
                    nearestDist = dist;
                    nearest = temp;
                }
                temp = temp.next;

            }
        }

        // Insert the new Node after the nearest node
        Node newNode = new Node(p);
        nearest.next = newNode;
        nearest = nearest.next;
        nearest.prev = newNode;
    }

    public void insertSmallest(Point p) {
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/

        Node temp = head;
        if (temp == null || temp.next == head) { // if the list is empty or it has only one node
            insertBeginning(p);
        }
        else {
            Node prevNode = temp;
            Node nextNode = temp.next;
            float prevDist = distanceBetween(prevNode.point, p);
            float nextDist = distanceBetween(nextNode.point, p);
            while (temp != head) {

            }
        }
    }

    public void reset() {
        head = null;
    }

    private class CircularLinkedListIterator implements Iterator<Point> {

        Node current;

        public CircularLinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Point next() {
            Point toReturn = current.point;
            current = current.next;
            if (current == head) {
                current = null;
            }
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Point> iterator() {
        return new CircularLinkedListIterator();
    }


}
