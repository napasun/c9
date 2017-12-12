//
//  TreePageViewController.swift
//  14_3_instaniateVC
//
//  Created by estgames on 2017. 12. 12..
//  Copyright © 2017년 estgames. All rights reserved.
//

import UIKit

class TreePageViewController: UIViewController {

    @IBAction func backToHome(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)   //현재 씬 닫기
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
