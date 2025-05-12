package org.hackerrank.day6;

class Node{
    public Node prev;
    public Node next;
    public final String url;

    public Node(final String url){
        this.url=url;
    }
}
class BrowserHistory {
    private Node cur;
    public BrowserHistory(String homepage) {
        cur=new Node(homepage);
    }

    public void visit(String url) {
        cur.next=new Node(url);
// set the back pointer
        cur.next.prev=cur;
        cur=cur.next;
    }

    public String back(int steps) {
        while(cur.prev != null && steps-->0){
            cur=cur.prev;
        }
        return cur.url;
    }

    public String forward(int steps) {
        while (cur.next != null && steps-- > 0) {
            cur = cur.next;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
