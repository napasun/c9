//
//  ViewController.swift
//  14_5_NavigationController
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var webView: UIWebView!
    
    var data:(name:String, url:String)?
    
    func openWeb() {//NSURL, NSURLRequest는 에러남
        if let webData = data {
            if let url2 =  URL(string: webData.url) {
                let urlReq = URLRequest(url: url2)
                webView.loadRequest(urlReq)
            }
        }
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        openWeb()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

