1）第一题：树（有多个children）的层次遍历
/**
* Definition for tree
* class TreeNode {
*     int val;
*     List<TreeNode> children;
* }
*/
要注意的是，输出不同层要记得换行。


2）第二题：
/* This class will be given a list of words (such as tokenized words from a paragraph of text).. visit 1point3acres.com for more.
* It will also provide a method that takes two words and returns the shortest distance(in words).鏈枃鍘熷垱鑷�1point3acres璁哄潧
* between these two words in the provided text..鏈枃鍘熷垱鑷�1point3acres璁哄潧
* Example:.1point3acres缃�
* WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList(“the”, “quick”, “brown”, “fox”, “quick”));
* assert(finder.distance(“fox”, “the”) == 3);
* assert(finder.distance(“quick”, “fox”) == 1);